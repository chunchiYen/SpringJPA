package com.example.log.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class ErrorLogFilter extends Filter<ILoggingEvent> { 
	@Override public FilterReply decide(ILoggingEvent event) { 
		if(event.getLevel().toString().equals("ERROR")) {
			return FilterReply.ACCEPT; 
		} else { 
			return FilterReply.DENY; 
		} 
	
	} 
}

