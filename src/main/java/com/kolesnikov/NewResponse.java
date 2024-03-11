package com.kolesnikov;

import java.util.Objects;

public class NewResponse {

    MyEntity myEntity;

    public NewResponse(MyEntity myEntity) {
        this.myEntity = myEntity;
    }

    public MyEntity getMyEntity() {
        return myEntity;
    }

    public void setMyEntity(MyEntity myEntity) {
        this.myEntity = myEntity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewResponse that = (NewResponse) o;

        return Objects.equals(myEntity, that.myEntity);
    }

    @Override
    public int hashCode() {
        return myEntity != null ? myEntity.hashCode() : 0;
    }
}
