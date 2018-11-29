package server.utils;

import io.netty.util.AttributeKey;
import server.model.session.Session;

public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
