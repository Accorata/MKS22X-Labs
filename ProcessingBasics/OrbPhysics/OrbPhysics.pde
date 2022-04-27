ArrayList<Orb>orbList;
float G = 40;
boolean Gravity = false;
boolean Background = true;
String mode = "GRAVITY";
Orb center;
void setup() {
  size(1000, 800);
  background(255);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2, height/2, 0, 0, 40);
}
void mouseClicked() {
  orbList.add(new Orb(mouseX, mouseY, 5, 0, 20));
}
void draw() {
  if (Background) { 
    background(255);
  }
  center.display();
  for (Orb o : orbList) {
    o.move();
    o.display();
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
}
void keyPressed() {
  if (keyCode == UP) {
    println("yes");
    while (orbList.size() > 0) {
      orbList.remove(0);
    }
  }
  if (key == 'g') {
    Gravity = !Gravity;
  }
  if (key == 'b') {
    Background = !Background;
  }
}

public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float radius;
  color c;

  public Orb(float x_, float y_, float xSpeed_, float ySpeed_, float radius_ ) {
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    //random color... why not.
    c = color(random(255), random(255), random(255));
  }


  void display() {
    noStroke();
    fill(c);
    ellipse(x, y, radius, radius);
    stroke(0);
    line(x, y, x+xSpeed*2, y+ySpeed*2);
  }

  void move() {
    x += xSpeed;
    y += ySpeed;
    if (mode == "GRAVITY") {
      if (x-radius/2 < 0) {
        xSpeed *= -1;
        x = radius/2;
      }
      if (x > width-radius/2) {
        xSpeed *= -1;
        x = width-radius/2;
      }
      if (y-radius/2 < 0) {
        ySpeed *= -1;
        y = radius/2;
      }
      if (y > height-radius/2) {
        ySpeed *= -1;
        y = height-radius/2;
      }
    } else if (mode == "ORBIT") {
      this.attract(center);
    } else if (mode == "SPRING") {
      this.attract(center);
    }
    if (Gravity) {
      ySpeed += 0.15;
    }
  }
  void attract(Orb other) {
    //float distanceSqr = ;
    float dist_x = x-other.x;
    float dist_y = y-other.y;
    float dist = sq(dist_x) + sq(dist_y);
    xSpeed -= G * (dist_x) / dist;
    ySpeed -= G * (dist_y) / dist;
  }
}
