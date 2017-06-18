package org.gosky.nga.data.entity;

import java.util.List;

/**
 * Created by zohar on 2017/6/18.
 * desc:
 */

public class BoardHolder {

    public BoardHolder(String categoryName, List<Board> boards) {
        this.categoryName = categoryName;
        this.boards = boards;
    }

    private String categoryName;
    private List<Board> boards;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
}
