int x, y;
float x2, y2;
float angle;
int MODE;
void setup() {
  size(800, 800);
  MODE = 3;
  x = width/2;
  y = height/2;
  frameRate(60);
}
void draw() {
  background(255);
  x = change(x);
  y = change(y);
  avatar(x, y);
  if (x2 == mouseX) {
    if (y2 != mouseY) {
      angle = PI/2*(y2-mouseY)/abs(y2-mouseY);
    }
  } else {
    angle = atan((y2-mouseY)/(x2-mouseX));
  }
  println(angle + " " + 2*cos(angle) + " " + 2*sin(angle));
  if (x2 <= mouseX){
    x2 += 2*cos(angle);
    y2 += 2*sin(angle);
  } else {
    x2 -= 2*cos(angle);
    y2 -= 2*sin(angle);
  }
  //if (x2 < mouseX) {
  //  x2++;
  //} else if (x2 > mouseX) {
  //  x2--;
  //}
  //if (y2 < mouseY) {
  //  y2++;
  //} else if (y2 > mouseY) {
  //  y2--;
  //}
  avatar((int)x2, (int)y2);
}
void mouseClicked() {
  MODE+=1;
  if (MODE == 4) {
    MODE = 1;
  }
}

void avatar(int x, int y) {
  for (float i = 0; i<10; i++) {
    push();
    translate(x, y);
    rotate(i/10*2*PI+(x+y)/10);
    stroke(0);
    line(0, 50, 40*cos(PI/5), 40*sin(PI/5));
    noStroke();
    fill(0,225);
    ellipse(0, 50, 10, 20);
    pop();
  }
  fill(100,150);
  ellipse(x, y, 40, 40);
}
int change(int value) {
  /**
   mode 1: return a random location on the screen.
   mode 2: change value by +1, 0, or -1 randomly
   mode 3: change value by +1 , but if it goes past the end of the screen ,
   wrap back around to the other end of the screen.
   */

  switch(MODE) {
  case 1:
    return (int)random(width);
  case 2:
    return value+(int)random(3)-1;
  case 3:
    if (value >= width) { 
      return 0;
    }
    return value+1;
  default:
    return width/2;
  }
}
