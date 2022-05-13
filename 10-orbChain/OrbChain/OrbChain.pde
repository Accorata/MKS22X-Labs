final static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = 0.35;
final static int MODE = SPRING;
static String CLICK_MODE = "Add";
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  if (CLICK_MODE == "Add"){
    orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
  }
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  fill(0);
  strokeWeight(1);
  text("Mode: "+CLICK_MODE, 50, 50);
}
void keyPressed() {
  if (key == ' '){
    if (CLICK_MODE == "Add") {
      CLICK_MODE = "Insert";
    } else if (CLICK_MODE == "Insert") {
      CLICK_MODE = "Delete";
    } else {
      CLICK_MODE = "Add";
    }
  } else if (key == '1') {
    SPRING_CONSTANT += 0.005;
  } else if (key == '2') {
    SPRING_CONSTANT -= 0.005;
    if (SPRING_CONSTANT < 0) SPRING_CONSTANT = 0;
  } else if (key == '3') {
    SPRING_DAMPEN += 0.001;
    if (SPRING_DAMPEN > 1) SPRING_DAMPEN = 1;
  } else if (key == '4') {
    SPRING_DAMPEN -= 0.001;
    if (SPRING_DAMPEN < 0) SPRING_DAMPEN = 0;
  } else if (key == '5') {
    SPRING_LENGTH += 5;
  } else if (key == '6') {
    SPRING_LENGTH -= 5;
    if (SPRING_LENGTH < 0) SPRING_LENGTH = 0;
  } else if (key == '7') {
    GRAVITY += 0.05;
  } else if (key == '8') {
    GRAVITY -= 0.05;
    if (GRAVITY < 0) GRAVITY = 0;
  }
}
