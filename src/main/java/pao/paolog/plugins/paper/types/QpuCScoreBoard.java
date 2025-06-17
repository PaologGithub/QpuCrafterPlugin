package pao.paolog.plugins.paper.types;

import io.papermc.paper.scoreboard.numbers.NumberFormat;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class QpuCScoreBoard {

    private final Scoreboard board;
    private final Objective objective;
    private int lineCount;

    public QpuCScoreBoard(String id, String title) {
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        this.board = scoreboardManager.getNewScoreboard();

        this.objective = board.registerNewObjective(id, Criteria.DUMMY, Component.text(title));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.numberFormat(NumberFormat.blank());

        // Because bigger the number is, "topper" the message is, we need to input a big number and reduce it.
        this.lineCount = 999;
    }

    public void show() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setScoreboard(this.board);
        }
    }

    public void hide() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
        }
    }

    public void addLine(String content) {
        Score line = objective.getScore(content);
        line.setScore(lineCount);
        lineCount -= 1;
    }
}
