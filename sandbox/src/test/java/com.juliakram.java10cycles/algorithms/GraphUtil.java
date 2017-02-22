package com.juliakram.java10cycles.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by jkramr on 2/22/17.
 */
public class GraphUtil {

    public static void bfs(TreeSet<? extends Node> unvisitedVertices) {
        Queue<Node> queue = new PriorityQueue<>();

        Node clusterRoot = unvisitedVertices.first();
        queue.add(clusterRoot);

        unvisitedVertices.remove(clusterRoot);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            TreeSet<Node> neighbours = node.getNeighbours();

            if (neighbours.isEmpty()) {
                return;
            }

            for (Node neighbor : neighbours) {
                if (unvisitedVertices.contains(neighbor)) {
                    queue.add(neighbor);
                    unvisitedVertices.remove(neighbor);
                }
            }
        }
    }

    public static void dfs(TreeSet<? extends Node> unvisitedNodes) {
        Node current = unvisitedNodes.first();

        Stack<Node> stack = new Stack<>();
        stack.push(current);
        unvisitedNodes.remove(current);

        while (!stack.isEmpty()) {
            Node node = stack.peek();

            TreeSet<Node> neighbours = node.getNeighbours();

            if (neighbours.isEmpty()) {
                stack.pop();
            }

            for (Node neighbor : neighbours) {
                if (unvisitedNodes.contains(neighbor)) {
                    stack.push(neighbor);
                    unvisitedNodes.remove(neighbor);
                } else {
                    stack.pop();
                }
            }
        }
    }

    public static void dfsRecursive(TreeSet<? extends Node> unvisitedNodes) {
        Node current = unvisitedNodes.first();

        unvisitedNodes.remove(current);

        for (Node neighbor : current.getNeighbours()) {
            if (unvisitedNodes.contains(neighbor)) {
                dfsRecursive(unvisitedNodes);
            }
        }
    }

    public static void bfsWithDepthTracking(TreeSet<? extends Node> unvisitedNodes) {
        Queue<Node> queue = new PriorityQueue<>();

        int currentDepth = 0;
        Node clusterRoot = unvisitedNodes.first();
        clusterRoot.depth = currentDepth;
        unvisitedNodes.remove(clusterRoot);
        queue.add(clusterRoot);


        while (!queue.isEmpty()) {
            Node current = queue.poll();
            currentDepth = current.depth;

            TreeSet<Node> neighbours = current.getNeighbours();

            if (neighbours.isEmpty()) {
                return;
            }

            for (Node neigbour : neighbours) {
                if (unvisitedNodes.contains(neigbour)) {
                    neigbour.depth = currentDepth + 1;
                    queue.add(neigbour);
                    unvisitedNodes.remove(neigbour);
                }
            }
        }
    }

    public static class Node {

        int depth;

        protected TreeSet<Node> neighbours = new TreeSet<>();

        public void add(Node node) {
            neighbours.add(node);
        }

        public TreeSet<Node> getNeighbours() {
            return neighbours;
        }
    }
}
