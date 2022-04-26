ArrayList<Orb>orbList;
    void setup() {
      size(1000, 800);
      orbList = new ArrayList<Orb>();
    }
    void mouseClicked() {
      //add a new Orb to the orbList, constructed as follows:
      //The x and y positions are the same as the mouse
      //the radius should be between in the range [20.0,70.0)
      //the xSpeed and ySpeed should be in the range [-3.0,3.0)
      orbList.add(new Orb(mouseX,mouseY,random(6)-3,random(6)-3,random(50)+20));
    }
    void draw() {
      background(255);
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
        //PART 2
        //change the x based on the xSpeed
        //change the y based on the ySpeed
        x += xSpeed;
        y += ySpeed;

        //PART 3
        //Change the speed when you collide with the end of the screen (all 4 sides)
        if (x-radius/2 < 0){
          xSpeed *= -1;
        }
        if(x > width+radius/2){
          xSpeed *= -1;
        }
        if (y-radius/2 < 0){
          ySpeed *= -1;
        }
        if (y > height+radius/2){
          ySpeed *= -1;
        }

        //Part 4
        //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
        //You don't need a variable for this if every object experiences the same
        //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).
        ySpeed += 0.02;
      }
    }
