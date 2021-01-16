package com.devsuperior.dslearnbds.obervers;

import com.devsuperior.dslearnbds.entities.Deliver;

public interface DeliverRevisionObserver {

    void onSaveRevision(Deliver deliver);

}
