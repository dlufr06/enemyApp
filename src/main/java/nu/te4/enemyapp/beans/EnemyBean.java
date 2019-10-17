/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.enemyapp.beans;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ejb.Stateless;
import nu.te4.enemyapp.enteties.Enemy;
import java.util.List;
import java.util.ArrayList;
import nu.te4.enemyapp.ConnectionFactory;

@Stateless
public class EnemyBean {

    public List<Enemy> getEnemys() {
        List<Enemy> enemys = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM enemy";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                int defence = data.getInt("defence");
                int attack = data.getInt("attack");
                int health = data.getInt("health");
                Enemy enemy = new Enemy(id, name, defence, attack, health);
                enemys.add(enemy);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return enemys;
    }

    public Enemy getEnemy(int id) {
        Enemy enemy = new Enemy();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM enemy WHERE id = " + id;
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                String name = data.getString("name");
                int defence = data.getInt("defence");
                int attack = data.getInt("attack");
                int health = data.getInt("health");
                enemy = new Enemy(id, name, defence, attack, health);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return enemy;
    }

    public int saveEnemy(Enemy enemy) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("INSERT INTO enemy VALUES(NULL,'%s',%d,%d,%d)",
                    enemy.getName(), enemy.getDefence(), enemy.getAttack(), enemy.getHealth());
            return stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }

    public int updateEnemy(Enemy enemy) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("UPDATE enemy SET name = '%s',defence = %d, attack = %d, health = %d WHERE id=%d",
                    enemy.getName(), enemy.getDefence(), enemy.getAttack(), enemy.getHealth(), enemy.getId());
            return stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }

}
