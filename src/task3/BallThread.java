package task3;

public class BallThread extends Thread {
    private Ball ball;
    private final int deltaGoal = 8;
    private final int ballSize = 20;
    private static int counter  = 0;

    public BallThread(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 10000; i++) {
                ball.move();
                //if (isGoal()) {
                    //interrupt();
                    //ball.remove();
                    //System.out.println("Score:" + ++counter); //score
                  //  return;
                //}
               /* System.out.println("Thread name = "
                        + Thread.currentThread().getName());*/
                Thread.sleep(5);

            }
        } catch (InterruptedException ex) {
        }
    }

    private boolean isGoal() {
        boolean leftTopGoal = ball.getX() < deltaGoal && ball.getY() < deltaGoal;
        boolean leftBottomGoal = ball.getX() < deltaGoal && ball.getY() > ball.getHeight() - deltaGoal - ballSize;
        boolean rightTopGoal = ball.getX() > ball.getWidth() - deltaGoal - ballSize && ball.getY() < deltaGoal;
        boolean rightBottomGoal = ball.getX() > ball.getWidth() - deltaGoal - ballSize && ball.getY() > ball.getHeight() - deltaGoal - ballSize;
        return leftTopGoal || leftBottomGoal || rightTopGoal || rightBottomGoal;
    }
}