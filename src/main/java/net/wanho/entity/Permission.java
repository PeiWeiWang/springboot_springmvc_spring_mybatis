package net.wanho.entity;

import java.io.Serializable;

public class Permission implements Serializable {

    private int id;
    private String name;
    private int pId;
    private String method;
    private boolean checked;
    private boolean open;

    public Permission() {
    }

    public Permission(int id, String name, int pId, String method) {
        this.id = id;
        this.name = name;
        this.pId = pId;
        this.method = method;
    }

    public Permission(int id, String name, int pId, String method, boolean checked, boolean open) {
        this.id = id;
        this.name = name;
        this.pId = pId;
        this.method = method;
        this.checked = checked;
        this.open = open;
    }

    public int getId() {
        return id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
