package fightclub2;

import java.util.ArrayList;
import java.util.Scanner;

public class Fightclub2 {

  private static final Scanner sc = new Scanner(System.in);
//klassern för spelare och motståndaren, inkluderar jab,cross,hookskada och hälsa
  static class Player {
    private int health;
    private final int jabDamage;
    private final int hookDamage;
    private final int crossDamage;

    public Player(int health, int jabDamage, int hookDamage, int crossDamage) {
      this.health = health;
      this.jabDamage = jabDamage;
      this.hookDamage = hookDamage;
      this.crossDamage = crossDamage;
    }
///hur klasserna används i koden
    public int getHealth() {
      return health;
    }

    public void setHealth(int health) {
      this.health = health;
    }

    public int getJabDamage() {
      return jabDamage;
    }

    public int getHookDamage() {
      return hookDamage;
    }

    public int getCrossDamage() {
      return crossDamage;
    }
  }

  static class Opponent {
    private int health;
    private final int jabDamage;
    private final int hookDamage;
    private final int crossDamage;
    private final int duckPunchProbability;

    public Opponent(int health, int jabDamage, int hookDamage, int crossDamage, int duckPunchProbability) {
      this.health = health;
      this.jabDamage = jabDamage;
      this.hookDamage = hookDamage;
      this.crossDamage = crossDamage;
      this.duckPunchProbability = duckPunchProbability;
    }

    public int getHealth() {
      return health;
    }

    public void setHealth(int health) {
      this.health = health;
    }

    public int getJabDamage() {
      return jabDamage;
    }

    public int getHookDamage() {
      return hookDamage;
    }

    public int getCrossDamage() {
      return crossDamage;
    }

    public int getDuckPunchProbability() {
      return duckPunchProbability;
    }
  }
//array listför lite komplexare kod 
  public static void main(String[] args) {
    Player player = new Player(100, 10, 20, 30);
    ArrayList<Opponent> opponents = new ArrayList<>();
    opponents.add(new Opponent(80, 15, 25, 35, 20));
    opponents.add(new Opponent(90, 12, 22, 32, 25));
    opponents.add(new Opponent(70, 16, 26, 36, 15));
    //counter för rundor och vinster
  int rounds = 3;
  int playerWins = 0;
  int opponentWins = 0;
  //loopens början med båda if och switch satser
  for (Opponent opponent : opponents) {
    for (int i = 0; i < rounds; i++) {
      while (player.getHealth() > 0 && opponent.getHealth() > 0) {
        System.out.println("Johan Kateby health: " + player.getHealth());
        System.out.println("Mike Tyson health: " + opponent.getHealth());
        System.out.println("Select a punch to throw quick!" );
        System.out.println("jabs are easy to hit but have minimal damage, hooks are the opposite and crosses are in between");
        System.out.println("1. Jab");
        System.out.println("2. Hook");
        System.out.println("3. Cross");

        System.out.print("Choose your move: ");
        int opponentDamage = 0;
        int playerMove = sc.nextInt();
        switch (playerMove) {
          case 1 -> {
              opponent.setHealth(opponent.getHealth() - player.getJabDamage());
              System.out.println("You punched with a Jab and dealt " + player.getJabDamage() + " damage");
              }
          case 2 -> {
              opponent.setHealth(opponent.getHealth() - player.getHookDamage());
              System.out.println("You punched with a Hook and dealt " + player.getHookDamage() + " damage");
              }
          case 3 -> {
              opponent.setHealth(opponent.getHealth() - player.getCrossDamage());
              System.out.println("You punched with a Cross and dealt " + player.getCrossDamage() + " damage");
              }
          default -> {
              System.out.println("Invalid move, try again.");
              continue;
              }
        }
//gör så fienden kan ducka
        if (opponent.getHealth() > 0) {
          int randomNum = (int) (Math.random() * 100);
          if (randomNum <= opponent.getDuckPunchProbability()) {
            opponentDamage = opponent.getCrossDamage() + (int) (Math.random() * 10);
            System.out.println("Opponent ducks and delivers a surprise punch for " + opponentDamage + " damage");
          } else {
            int randomMove = (int) (Math.random() * 3) + 1;
            switch (randomMove) {
              case 1 -> {
                  opponentDamage = opponent.getJabDamage();
                  System.out.println("Opponent punched with a Jab and dealt " + opponentDamage + " damage");
                  }
              case 2 -> {
                  opponentDamage = opponent.getHookDamage();
                  System.out.println("Opponent punched with a Hook and dealt " + opponentDamage + " damage");
                  }
              case 3 -> {
                  opponentDamage = opponent.getCrossDamage();
                  System.out.println("Opponent punched with a Cross and dealt " + opponentDamage + " damage");
                  }
            }
          }
          player.setHealth(player.getHealth() - opponentDamage);
        }
       //resultat på rundan
    else if (opponent.getHealth() > 0) {
        System.out.println("You lost this round!");
        opponentWins++;
      } else {
        System.out.println("This round was a tie!");
      }
      player.setHealth(100);
      opponent.setHealth(opponent.getHealth());
    }
  }
       //resultat på matchen

  System.out.println("Final Results:");
  System.out.println("Player Wins: " + playerWins);
  System.out.println("Opponent Wins: " + opponentWins);
  if (playerWins > opponentWins) {
    System.out.println("You won the match!");
  } else if (opponentWins > playerWins) {
    System.out.println("You lost the match!");
  } else {
    System.out.println("The match was a tie!");      
    }}}}
  

