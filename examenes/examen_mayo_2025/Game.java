import java.util.Iterator;
import java.util.TreeSet;

public class Game {
    public static int panelWidth = 600;  // Ancho del panel
    public static int panelHeight = 400; // Alto del panel

    private Ball ball;
    private Slider slider;
    private int score = 0;
    private int speedIncrementInterval = 2000; // Incremento de velocidad cada 3 segundos
    private long lastSpeedIncreaseTime;
    private long lastUpdateTime = System.currentTimeMillis(); // Última actualización en milisegundos
    private long startTime = -1; // Tiempo de inicio del juego (-1 indica que aún no ha comenzado)
    private boolean running = true;
    private boolean gameOver = false; // Indica si el juego ha terminado
    private boolean firstRun = true; // Indica si es la primera ejecución del juego
    private TreeSet<Integer> topScores = new TreeSet<>(); // TreeSet para almacenar las puntuaciones
    private double sliderSpeed = 400; // Velocidad inicial del slider en px/s

    public Game() {
        ball = new Ball(); // Crear la pelota con sus valores iniciales
        slider = new Slider(); // Crear el slider con sus valores iniciales
        lastSpeedIncreaseTime = System.currentTimeMillis();
    }

    public void updateGame(int panelWidth, int panelHeight) {
        long currentTime = System.currentTimeMillis();
        double deltaTime = (currentTime - lastUpdateTime) / 1000.0; // Tiempo transcurrido en segundos
        lastUpdateTime = currentTime;

        if (!gameOver) {
            // Inicializar el tiempo de inicio si aún no se ha hecho
            if (startTime == -1) {
                startTime = currentTime;
            }

            // Actualizar la posición de la pelota
            ball.move(deltaTime);

            // Rebote contra la paleta
            if (ball.getBounds().intersects(slider.getBounds())) {
                adjustBallTrajectory();
            }

            // Si la pelota toca el suelo, termina el juego
            if (ball.getY() + ball.getHeight() >= panelHeight) {
                gameOver = true;
                running = false; // Detener el hilo
                if (!firstRun)
                    updateTopScores(); // Actualizar el Top 3 de puntuaciones
            }

            // Incrementar la velocidad cada 3 segundos
            if (currentTime - lastSpeedIncreaseTime >= speedIncrementInterval) {
                ball.increaseSpeed(20); // Incrementar velocidad de la pelota en px/s
                sliderSpeed += 20; // Incrementar velocidad del slider en px/s
                lastSpeedIncreaseTime = currentTime;
            }

            // Actualizar la puntuación basada en el tiempo
            if (startTime != -1) { // Solo actualizar la puntuación si el juego ha comenzado
                score = (int) ((currentTime - startTime) / 1000);
            }
        }
    }

    public void moveSliderLeft(int panelWidth, double deltaTime) {
        slider.moveLeft(sliderSpeed * deltaTime);
    }

    public void moveSliderRight(int panelWidth, double deltaTime) {
        slider.moveRight(sliderSpeed * deltaTime);
    }

    public void resetGame() {
        ball.reset(); // Reiniciar la pelota a sus valores iniciales
        sliderSpeed = 400; // Reiniciar la velocidad del slider
        score = 0;
        startTime = -1; // Reiniciar el tiempo de inicio
        lastSpeedIncreaseTime = System.currentTimeMillis();
        lastUpdateTime = System.currentTimeMillis();
        gameOver = false;
        running = true;

        // Cambiar `firstRun` a `false` solo después de la primera partida
        if (firstRun) {
            firstRun = false;
        }
    }

    private void adjustBallTrajectory() {
        // Calcular la posición relativa del rebote en el slider
        int sliderCenter = slider.getX() + slider.getWidth() / 2;
        int ballCenter = ball.getX() + ball.getWidth() / 2;
        int relativePosition = ballCenter - sliderCenter;

        // Ajustar la dirección de la pelota en función de la posición del rebote
        if (relativePosition < 0) { // Rebote en el lado izquierdo
            ball.setSpeedX(-Math.abs(ball.getSpeedX()));
        } else if (relativePosition > 0) { // Rebote en el lado derecho
            ball.setSpeedX(Math.abs(ball.getSpeedX()));
        }

        // Invertir la dirección vertical de la pelota
        ball.reverseY();
    }

    private void updateTopScores() {
        // Agregar la puntuación actual al TreeSet
        topScores.add(score);

        // Limitar el TreeSet a las 3 mejores puntuaciones
        while (topScores.size() > 3) {
            topScores.pollFirst(); // Eliminar la puntuación más baja
        }
    }

    public Ball getBall() {
        return ball;
    }

    public Slider getSlider() {
        return slider;
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isFirstRun() {
        return firstRun;
    }

    public Iterator<Integer> getTopScoresDescending() {
        return topScores.descendingIterator();
    }
}