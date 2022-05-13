final static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = 0.35;
final static int MODE = SPRING;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
}
void keyPressed() {
  if (key == '1') {
    SPRING_CONSTANT += 0.005;
  } else if (key == '2') {
    SPRING_CONSTANT -= 0.005;
    if (SPRING_CONSTANT < 0) SPRING_CONSTANT = 0;
  }
  println(SPRING_CONSTANT);
}
