public class OrbList {
  public OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }
  void add(OrbNode orb) {
    orb.next = last;
    orb.prev = last.prev;
    last.prev.next = orb;
    last.prev = orb;
  }
  void add(int xcor,OrbNode toBeAdded){
    OrbNode current = first;
    while (current != null && xcor >= current.x){
      current.move();
      current = current.next;
    }
    toBeAdded.next = current;
    if (current != null){
      toBeAdded.prev = current.prev;
      current.prev.next = toBeAdded;
      current.prev = toBeAdded;
    }
  }
  void delete(OrbNode target) {
    target = getNodeAt(mouseX, mouseY);
    if (target != null) {
      target.prev.next = target.next;
      target.next.prev = target.prev;
    }
  }
  OrbNode getNodeAt(float x, float y) {
    OrbNode current = first.next;
    while (current != null && current != last){
      if (dist(x, y, current.x, current.y) <= current.radius) {
        return current;
      }
      current = current.next;
    }
    return null;
  }
  void processAll() {
    OrbNode current = first;
    while (current != null){
      current.move();
      current = current.next;
    }
  }
  void display() {
    OrbNode current = first;
    while (current != null){
      current.display();
      current = current.next;
    }
  }
}
