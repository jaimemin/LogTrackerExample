package com.tistory.jaimemin.advanced.trace.logtrace;

import com.tistory.jaimemin.advanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
