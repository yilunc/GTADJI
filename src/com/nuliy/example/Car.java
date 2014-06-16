/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nuliy.example;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


/**
 *
 * @author Owner
 */
public class Car {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    World world; 
    Box2DDebugRenderer box2Drender;

    BodyDef bodyD;
    
    Body body;
    

    FixtureDef CarFixDef;
    PolygonShape CarBody;
    
    

    private final float MaxTurnAngle = (float) Math.PI / 3;
    private final float AngleSpeed = 10.5f;
    private final float SidewaysFriction = 10f;
    private final float Horsepower = 500f;

    private float x;
    private float y;
    private float enginespeed;
    private float steerAng;
    private final float YPrc = 0.15f;
    private final float XPrc = 0.60f;

    private Vector2 Cpos;

    private final float width = 50;
    private final float length = 70;
    private float angle;

    private final float force = 6.6f * 1500f;

//    BodyDef bodyD, FixtureDef fixtureD, 
    public Car(float x, float y) {

        //initialize
        this.world = new World(new Vector2(0, 0), false);
        this.box2Drender = new Box2DDebugRenderer();

        this.CarBody = new PolygonShape();
        

        this.bodyD = new BodyDef();
        this.CarFixDef = new FixtureDef();
    
        this.x = x;
        this.y = y;
        this.Cpos = new Vector2(x,y);
        

        //setting bodyDef damping (Regular slow)
        bodyD.linearDamping = 0.5f;
        bodyD.angularDamping = 2f;
        
        //Adding bodyDef to the world and setting type as Dynamic
        body = world.createBody(bodyD);
        body.setType(BodyDef.BodyType.DynamicBody);
        
        //setting the body position in the world using the Vector given.
        body.setTransform(this.Cpos, (float) ((Math.PI) / 2));

        
 

        //Setting the car(box) and wheel size
        CarBody.setAsBox(this.length, this.width);
       
        CarFixDef.shape = CarBody;

     
        body.createFixture(CarFixDef);

      

    }

    public void KillOrthoVelocity(Body body) {
        Vector2 localP = new Vector2(0, 0);
        Vector2 velocity = body.getLinearVelocityFromLocalPoint(localP);

        float r = body.getTransform().getRotation();
        Vector2 sideways = new Vector2((float) -Math.sin(r), (float) Math.cos(r));
        sideways.scl(velocity.dot(sideways));

        body.setLinearVelocity(sideways);
    }

    public Vector2 GetCarPos() {
        return Cpos;
    }

    public float GetCarAng() {
        this.angle = body.getAngle();

        return angle;
    }

    public void GetCarV() {
        this.body.getLinearVelocityFromWorldPoint(Cpos);
    }

    public void Up() {
        body.applyForceToCenter((float)(Math.cos(body.getAngle())*force),(float)(Math.sin(body.getAngle())*force), true);
    }

    public void TurnLeft() {
        this.body.setAngularVelocity(3);
        
        Vector2 localP = new Vector2(0, 0);
        Vector2 velocity = body.getLinearVelocityFromLocalPoint(localP);
        
        
        this.body.setLinearVelocity(0,0);
//        if(body.getAngle() != 0){
//        Vector2 XY = new Vector2(((float)((Math.cos(body.getAngle()))*force)),((float)((Math.sin(body.getAngle()))*force)));
//        this.body.applyLinearImpulse(linearV, XY, true);
//        }
//        Vector2 XY = new Vector2(((float)((Math.cos(body.getAngle()))*-force)),((float)((Math.sin(body.getAngle()))*-force)));
        this.body.applyLinearImpulse(velocity, Cpos, true);
        System.out.println("LEFT");
    }

    public void TurnRight() {
        this.body.setAngularVelocity(-3);
        
        
        Vector2 localP = new Vector2(0, 0);
        Vector2 velocity = body.getLinearVelocityFromLocalPoint(localP);
        
        
        this.body.setLinearVelocity(0,0);
        this.body.applyLinearImpulse(velocity, Cpos, true);
        System.out.println("RIGHT");
    }

    public void Reverse() {
        body.applyForceToCenter((float)(Math.cos(body.getAngle())*-force),(float)(Math.sin(body.getAngle())*-force), true);
    }

    public void NoAcceleration() {
        body.setLinearDamping(0.1f);
    }

    public void noTurn() {
        body.setAngularDamping(2f);
    }

    public void updateCar(float dt) {
        Vector2 zeroV = new Vector2 (0,0);
        if((body.getLinearVelocity() == zeroV) && (body.getAngularVelocity() != 0f))
        {
//            if(body.getAngularVelocity() > 0)
//            {
                if(body.getAngle() < Math.PI && body.getAngle() > Math.PI/2) //Second Q
                {
                    body.setLinearVelocity(((float)Math.cos(body.getAngle())*-body.getAngularVelocity()), (float)Math.sin(body.getAngle())*body.getAngularVelocity());
                }
                else if(body.getAngle() > Math.PI && body.getAngle() < Math.PI*(3/4)) //Third Q
                {
                    body.setLinearVelocity(((float)Math.cos(body.getAngle())*-body.getAngularVelocity()), (float)Math.sin(body.getAngle())*-body.getAngularVelocity());
                }
                else if(body.getAngle() > Math.PI*(3/4) && body.getAngle() < Math.PI*(2)) //Forth Q
                {
                    body.setLinearVelocity(((float)Math.cos(body.getAngle())*body.getAngularVelocity()), (float)Math.sin(body.getAngle())*-body.getAngularVelocity());
                }
                else if(body.getAngle() > 0 && body.getAngle() < Math.PI/2) //First Q
                {
                    body.setLinearVelocity(((float)Math.cos(body.getAngle())*body.getAngularVelocity()), (float)Math.sin(body.getAngle())*body.getAngularVelocity());
                }
                
//            }
//            if(body.getAngularVelocity() < 0)
//            {
////                body.getLinearVelocity() = ()
//            }
            
        }
        world.step(dt, 6, 2);
    }

    public void render(Matrix4 combined) {
        box2Drender.render(world, combined);
    }
}



