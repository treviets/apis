package net.cd.service.xtras.impl;

import net.cd.dto.xtras.CdXGoogleURLShortenerDto;
import net.cd.dto.xtras.CdXURLShortenerDto;
import net.cd.service.xtras.CdXGoogleURLShortenerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Vincent 01/12/2017
 */
@Service
public class CdXGoogleURLShortenerServiceImpl implements CdXGoogleURLShortenerService {

    private final String opXGoogleURLShortenerEndpoint = "https://www.googleapis.com/urlshortener/v1/url?key=%s";

    @Autowired
    @Value("#{cdKeyGoogleAPI}")
    private String cdKeyGoogleAPI;

    public CdXURLShortenerDto shortenByLongURL(String url) {

        RestTemplate restTemplate = new RestTemplate();
        CdXGoogleURLShortenerDto cdXGoogleURLShortenerDto = new CdXGoogleURLShortenerDto();
        cdXGoogleURLShortenerDto.setLongUrl(url);
        cdXGoogleURLShortenerDto = restTemplate.postForObject(String.format(opXGoogleURLShortenerEndpoint, cdKeyGoogleAPI), cdXGoogleURLShortenerDto, CdXGoogleURLShortenerDto.class);

        CdXURLShortenerDto cdXURLShortenerDto = new CdXURLShortenerDto();
        ModelMapper mapper = new ModelMapper();
        mapper.map(cdXGoogleURLShortenerDto, cdXURLShortenerDto);
        return cdXURLShortenerDto;
    }
}
