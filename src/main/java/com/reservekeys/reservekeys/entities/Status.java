package com.reservekeys.reservekeys.entities;

public enum Status {
    INDISPONIVEL(0),

    DISPONIVEL(1);

    private final int status;

    Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public static int valueOf(int status) {
        for (Status value : Status.values()) {
            if (value.getStatus() == status) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Order Status code!");
        //throw new ServiceException("Campo em Branco!");
    }
}
