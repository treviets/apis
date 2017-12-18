package net.cd.service.xtras;

import net.cd.dto.xtras.CdXURLShortenerDto;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdXGoogleURLShortenerService {

    CdXURLShortenerDto shortenByLongURL(String url);
}
