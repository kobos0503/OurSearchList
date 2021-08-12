package com.kobos.oursearchlist.model.service;

import java.io.IOException;

public interface YoutubeAPIService {

	String searchYoutubeChannelInfo(String youtubeURL) throws IOException, Exception;

}
