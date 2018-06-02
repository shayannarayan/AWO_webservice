package com.awo.app.dao.image;

import com.awo.app.domain.image.Image;
import com.awo.app.response.Response;

public interface ImgDao {

	Response saveImg(Image img);

	Image getImg(int regId);

}
