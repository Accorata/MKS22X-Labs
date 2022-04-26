ArrayList<Orb>orbList;
float G = 20;
boolean Gravity = false;
Orb center;
    void setup() {
      size(1000, 800);
      orbList = new ArrayList<Orb>();
      center = new Orb(width/2,height/2,0,0,40);
    }
    void mouseClicked() {
      orbList.add(new Orb(mouseX,mouseY,random(6)-3,random(6)-3,random(50)+20));
    }
    void draw() {
      background(255);
      center.display();
      for (Orb o : orbList) {
        o.move();
        o.display();
      }
      fill(0);
      text(frameRate,20,20);
      text(orbList.size(),20,40);
    }
public class Orb{
      float x,y;
      float xSpeed,ySpeed;
      float radius;
      color c;

      public Orb(float x_,float y_,float xSpeed_, float ySpeed_, float radius_ ){
        x = x_;
        y = y_;
        xSpeed = xSpeed_;
        ySpeed = ySpeed_;
        radius = radius_;
        //random color... why not.
        c = color(random(255),random(255),random(255));
      }


      void display(){
        noStroke();
        fill(c);
        ellipse(x,y,radius,radius);
      }

      void move(){
        x += xSpeed;
        y += ySpeed;
        if (x-radius/2 < 0){
          xSpeed *= -1;
          x = radius/2;
        }
        if(x > width-radius/2){
          xSpeed *= -1;
          x = width-radius/2;
        }
        if (y-radius/2 < 0){
          ySpeed *= -1;
          y = radius/2;
        }
        if (y > height-radius/2){
          ySpeed *= -1;
          y = height-radius/2;
        }
        if(Gravity) {
          ySpeed += 0.15;
        } else {
          this.attract(center);
        }
      }
      void attract(Orb other) {
        //float distanceSqr = ;
        xSpeed += G * x-other.x / (sq(x-other.x) + sq(y-other.y));
        ySpeed += G * y-other.y / (sq(x-other.x) + sq(y-other.y));
      }
    }
