package com.meowu.svc.lilith.app.commons.struct.constant.graph;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraphType;
import com.cosium.spring.data.jpa.entity.graph.domain2.NamedEntityGraph;

public interface AccountGraph{

    String WITH_USER  = "Account.withUser";
    String WITH_EMAIL = "Account.withEmail";
    String WITH_PHONE = "Account.withPhone";
    String WITH_ALL   = "Account.withAll";

    NamedEntityGraph WITH_USER_GRAPH  = new NamedEntityGraph(EntityGraphType.FETCH, WITH_USER);
    NamedEntityGraph WITH_EMAIL_GRAPH = new NamedEntityGraph(EntityGraphType.FETCH, WITH_EMAIL);
    NamedEntityGraph WITH_PHONE_GRAPH = new NamedEntityGraph(EntityGraphType.FETCH, WITH_PHONE);
    NamedEntityGraph WITH_ALL_GRAPH   = new NamedEntityGraph(EntityGraphType.FETCH, WITH_ALL);
}
