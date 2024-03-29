// 1. Follow the recipe instructions inside the Segment class.

// The Segment class will be used to represent each part of the moving snake.

class Segment {
  //2. Create x and y member variables to hold the location of each segment.
  int x = 0;
  int y = 0;
  // 3. Add a constructor with parameters to initialize each variable.
  Segment (int x, int y) {
    this.x = x;
    this.y = y;
  }
  // 4. Add getter and setter methods for both the x and y member variables.
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

// 5. Create (but do not initialize) a Segment variable to hold the head of the Snake
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

int[] xy = {50, 150, 250, 350};
int index = int(random(xy.length)); 

Segment block1;
int block1X = xy[index];
int block1Y = xy[index];
int blockWidth = 10;
// 6. Create and initialize a String to hold the direction of your snake e.g. "up"
// 7. Create and initialize a variable to hold how many pieces of food the snake has eaten.
// give it a value of 1 to start.
// 8. Create and initialize foodX and foodY variables to hold the location of the food.
int block2X = xy[index];
int block2Y = xy[index];
while (block1X == block2X && block1Y == block2Y) {
  int block2X = xy[index];
  int block2Y = xy[index];
}

// (Hint: use the random method to set both the x and y to random locations within the screen size (500 by 500).)
//int foodX = ((int)random(50)*10);

void setup() {
  // 9. Set the size of your sketch (500 by 500).
  size(400, 400);
  // 10. initialize your head to a new segment.
  block1 = new Segment(block1X, block1Y);
  // 11. Use the frameRate (int rate) method to set the rate to 20.
  frameRate(10);
}

void draw() {
  background(0);
  //12. Call the manageTail, drawFood, drawSnake, move, and collision methods.
  manageTail();
  drawFood();
  drawSnake();
  move();
  collision();
}

// 13. Complete the drawFood method below. (Hint: each piece of food should be a 10 by 10 rectangle).

void drawFood() {
  rect(foodX, foodY, foodWidth, foodWidth);
}

//14. Draw the snake head (use a 10 by 10 rectangle)

void drawSnake() {
  rect(block1.getX(), block1.getY(), 10, 10);
  //test your code
}
// 15. Complete the move method below.

void move() {
  // 16. Using a switch statement, make your snake head move by 10 pixels in the correct direction.
  //This is an incomplete switch statement:
  /*
  switch(dir) {
   case "up":
   // move head up here 
   break;
   case "down":
   // move head down here 
   break;
   case "left":
   // figure it out 
   break;
   case "right":
   // mystery code goes here 
   break;
   }
   */
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
  // 17. Call the checkBoundaries method to make sure the snake head doesn't go off the screen.
  checkBoundaries();
}

// 18. Complete the keyPressed method below. Use if statements to set your direction variable depending on what key is pressed.

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
    }
  }
}

// 19. check if your head is out of bounds (teleport your snake head to the other side).

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

// 20. Make sure that the key for your current direction’s opposite doesn’t work (i.e. If you’re going up, down key shouldn’t work).

// 21. Complete the missing parts of the collision method below.

void collision() {
  // If the segment is colliding with a piece of food...
  // Increase the amount of food eaten and set foodX and foodY to new random locations.
  if (block1.getX()+blockWidth>foodX && block1.getX()<foodX+foodWidth) {
    if (block1.getY()+blockWidth>foodY && block1.getY()<foodY+foodWidth) {
      foodX = ((int)random(50)*10);
      foodY = ((int)random(50)*10);
      drawFood();
    }
  }
}

// Part 2: making the tail (the rest of the snake)

//  1. Create and initialize an ArrayList of Segments. (This will be your snake tail!)

// 2. Complete the missing parts of the manageTail method below and call it in the draw method.

void manageTail() {
  //Call the drawTail and checkTailCollision methods.
  drawTail();
  checkTailCollision();
  // Add a new Segment to your ArrayList that has the same X and Y as the head of your snake.
  //tail.add(new Segment(block1.getX(), block1.getY()));
  // To keep your tail the right length:
  // while the tail size is greater than the number of food pieces eaten, remove the first Segment in your tail.
  //while (tail.size()>foodEaten) {
  //  tail.remove(0);
  //}
}

void drawTail() {
  // Draw a 10 by 10 rectangle for each Segment in your snake ArrayList.

  //for (int i = 0; i < tail.size(); i++) {
  //  rect(tail.get(i).getX(), tail.get(i).getY(), 10, 10);
  //}

  //Messed-up code:
  //for (int i = 0; i < tail.size(); i++) {
  //  Segment s = tail.get(i);
  //  rect(tail.size()10, +10, 10, 10);
  //}

  //More messed-up code:
  //for (int i = 0; i < tail.size(); i++) {
  //  if (direction == "up") {
  //    rect(head.getX(), head.getY()+tail.size()*10, 10, 10);
  //  }
  //  if (direction == "down") {
  //    rect(head.getX(), head.getY()-tail.size()*10, 10, 10);
  //  }
  //  if (direction == "left") {
  //    rect(head.getX()+tail.size()*10, head.getY(), 10, 10);
  //  }
  //  if (direction == "right") {
  //    rect(head.getX()-tail.size()*10, head.getY(), 10, 10);
  //  }
  //}
}


// 3. Complete the missing parts of the bodyCollision method below.

void checkTailCollision() {
  // If your head has the same location as one of your segments...
  //println(tail.size());
  //for (int i = 0; i < tail.size(); i++) {
  //  if (block1.getX() == tail.get(i).getX() && block1.getY() == tail.get(i).getY()) {
  //    foodEaten = 1;
}
//}
// reset your food variable
//}
