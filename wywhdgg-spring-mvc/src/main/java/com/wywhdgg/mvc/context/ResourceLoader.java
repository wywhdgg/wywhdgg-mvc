package com.wywhdgg.mvc.context;

import java.io.IOException;

public interface ResourceLoader {

	Resource getResource(String location) throws IOException;
}
