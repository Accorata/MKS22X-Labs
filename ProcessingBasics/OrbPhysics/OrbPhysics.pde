ArrayList<Orb>orbList;
float G = 25;
boolean Gravity = false;
boolean Background = true;
String mode = "ORBIT";
float SPRING_CONSTANT = 0.01, SPRING_LENGTH = 200, SPRING_DAMPEN = 0.995;
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
  noStroke();
  fill(255);
  rect(10,0,120,120);
  if (Background) { 
    background(255);
  }
  center.display();
  for (Orb o : orbList) {
    o.move();
    o.display();
      if (mode == "ORBIT") {
      center.attract(o);
    } else if (mode == "SPRING") {
      center.attractSpring(o);
    }
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  text(mode, 20, 60);
  text("Gravity: "+Gravity, 20, 80);
  text("Background: "+Background, 20, 100);
}
void keyPressed() {
  if (keyCode == 8) {
    while (orbList.size() > 0) {
      orbList.remove(0);
    }
  }
  if (key == ' ') {
    if (mode == "SPRING"){
      mode = "GRAVITY";
    } else if (mode == "GRAVITY"){
      mode = "ORBIT";
    } else {
      mode = "SPRING";
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
    line(x, y, x+xSpeed*3, y+ySpeed*3);
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
    }
    if (Gravity) {
      ySpeed += 0.15;
    }
  }
  void attract(Orb other) {
    //float distanceSqr = ;
    float dist_x = x-other.x;
    float dist_y = y-other.y;
    float dist = sq(dist_x)+sq(dist_y);
    other.xSpeed += G * (dist_x) / dist;
    other.ySpeed += G * (dist_y) / dist;
  }
  void attractSpring(Orb other) {
    stroke(0);
    line(x,y,other.x,other.y);
    float dist_x = x-other.x;
    float dist_y = y-other.y;
    float dist = dist(x,y,other.x,other.y);
    other.xSpeed += SPRING_CONSTANT * (dist - SPRING_LENGTH) * dist_x/dist;
    other.ySpeed += SPRING_CONSTANT * (dist - SPRING_LENGTH) * dist_y/dist;
    other.xSpeed *= SPRING_DAMPEN;
    other.ySpeed *= SPRING_DAMPEN;
  }
}
