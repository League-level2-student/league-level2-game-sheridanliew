//menu, game, end state
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
//first starter block
Block block1;
int[] xy = {50, 150, 250, 350};
int index = int(random(xy.length));
String direction = "down";
//random block location in grid
int block1X = xy[index];
int block1Y = xy[index];
int blockWidth = 10;
//second starter block
Block block2;
int block2X = xy[index];
int block2Y = xy[index];
//gameboard
Block[][] board;

class Block {
  int x;
  int y;
  Block (int x, int y) {
    this.x = x;
    this.y = y;
  }
  //getters and setters
  int getX () {
    return this.x;
  }
  void setX (int x) {
    this.x = x;
  }
  int getY () {
    return this.y;
  }
  void setY (int y) {
    this.y = y;
  }
}

void setup() {
  size(1024, 1024);
  background(0);
  noStroke();
  fill(102);
  block1 = new Block(block1X, block1Y);
  frameRate(10);
}

void draw() {
  initializeMenuState();
}

void initializeMenuState() {
  textSize(104);
  text("Mix", 10, 95);
  textSize(36);
  text("a 2048 game", 10, 170);
  text("Press ENTER to start", 10, 220);
}

void initializeGameState() {
  drawBlock();
  move();
}

void initializeEndState() {
}

void drawBlock() {
  rect(block1.getX(), block1.getY(), blockWidth, blockWidth);
}

void move() {
  switch(direction) {
  case "up":
    block1.setY(block1.getY()-100);
    break;
  case "down":
    block1.setY(block1.getY()+100);
    break;
  case "left":
    block1.setX(block1.getX()-100);
    break;
  case "right":
    block1.setX(block1.getX()+100);
    break;
  }
  checkBoundaries();
}

void keyPressed() {
  if (key == CODED) {
    if (keyCode == UP) {
      if (!direction.equals("down")) {
        direction = "up";
      }
    } else if (keyCode == DOWN) {
      if (!direction.equals("up")) {
        direction = "down";
      }
    } else if (keyCode == LEFT) {
      if (!direction.equals("right")) {
        direction = "left";
      }
    } else if (keyCode == RIGHT) {
      if (!direction.equals("left")) {
        direction = "right";
      }
    } else if (keyCode == ENTER) {
      if (currentState == END) {
        currentState = MENU;
        initializeMenuState();
      } else if (currentState == MENU) {
        currentState++;
        initializeGameState();
      } else if (currentState == GAME) {
        currentState++;
        initializeEndState();
      }
    }
  }
}

void checkBoundaries() {
  if (block1.getX()<=0) {
    block1.setX(width);
  } else if (block1.getX()>=width) {
    block1.setX(0);
  } else if (block1.getY()<=0) {
    block1.setY(width);
  } else if (block1.getY()>=height) {
    block1.setY(0);
  }
}



//void collision() {
//  if (block1.getX()+blockWidth>block2.getX() && block1.getX()<block2.getX()+blockWidth) {
//    if (block1.getY()+blockWidth>block2.getY() && block1.getY()<block2.getY()+blockWidth) {
//      block2.setX(xy[index]);
//      block2.setY(xy[index]);
//    }
//  }
//}
//ArrayList<Block> blocks = new ArrayList<Block>();
//void manageTail() {
//  drawTail();
//  checkTailCollision();
//}

//void drawTail() {
//  for (int i = 0; i < blocks.size(); i++) {
//    rect(blocks.get(i).getX(), blocks.get(i).getY(), 10, 10);
//  }
//}

//void checkTailCollision() {

//  println(blocks.size());
//  for (int i = 0; i < blocks.size(); i++) {
//    if (block1.getX() == blocks.get(i).getX() && block1.getY() == blocks.get(i).getY()) {
//    }
//  }
//}


//50, 50
//50, 150
//50, 250
//50, 350
//150, 50
//150, 150
//150, 250
//150, 350
//250, 50
//250, 150
//250, 250
//250, 350
//350, 50
//350, 150
//350, 250
//350, 350

//2, 4, 16, 256
//1024
