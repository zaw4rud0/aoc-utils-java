package dev.zawarudo.aoc_utils;

import dev.zawarudo.aoc_utils.graph.AdventOfCodeGraph;
import dev.zawarudo.aoc_utils.graph.ChartType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Amos' leaderboard id: 951576
// Lu's leaderboard id: 1514956

public class Main {

    public static void main(String[] args) throws IOException {
        String session = loadToken();

        AdventOfCodeGraph graph = AdventOfCodeGraph.createGraph(ChartType.STACKED_BAR_CHART, 2023, 1514956, session);
        // graph.setTheme(GraphTheme.WOOD);
        BufferedImage image = graph.generateImage();

        String name = String.format("aoc_%s.png", getCurrentDateTime());
        File file = new File("./out/graphs/" + name);
        new File(file.getParent()).mkdirs();
        ImageIO.write(image, "png", file);
    }

    private static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss");
        return now.format(formatter);
    }

    private static String loadToken() throws IOException {
        return Files.readString(Path.of("token.txt")).trim();
    }
}