public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }
  void add(OrbNode orb) {
    last.prev.next = orb;
    last.prev = orb;
    orb.next = last;
    orb.prev = last.prev;
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
