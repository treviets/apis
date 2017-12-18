package net.cd.jpa.entity.security;

/**
 * Created by Tree.Yip on 25/6/2017.
 */
public interface CdKMemberVisitable {
    <R, E extends Throwable> R accept(CdKMemberVisitor<R, E> visitor) throws E;
}
