package net.cd.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.cd.common.util.UserUtil;
import net.cd.common.web.BaseEndpoint;
import net.cd.dto.kernal.CdCommentDto;
import net.cd.dto.kernal.CdFeedDto;
import net.cd.dto.kernal.CdKMemberDto;
import net.cd.dto.kernal.CdLikeDto;
import net.cd.exception.CdErrors;
import net.cd.exception.CdException;
import net.cd.service.kernal.CdCommentService;
import net.cd.service.kernal.CdFeedService;
import net.cd.service.kernal.CdKMemberService;
import net.cd.service.kernal.CdLikeService;

/**
 * Created by Vincent on 07/12/2017.
 */
@RestController
@RequestMapping("/feed")
@Api(value = "Feed API Endpoint", description = "Feed Data Entities Endpoint")
public class CdFeedEndpoint extends BaseEndpoint {

	
	@Autowired
	private CdFeedService feedService;
	
	@Autowired
	private CdKMemberService memberService;
	
	@Autowired
	private CdCommentService commentService;

	@Autowired
	private CdLikeService likeService;
	
	@Autowired
	UserUtil userUtil;
	
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation("Fetch member details")
    public List<CdFeedDto> fetchFeeds() throws Exception {
        List<CdFeedDto> feeds = feedService.findAll();
        return feeds;
    }
    
    @RequestMapping(value = "/{reference}", method = RequestMethod.GET)
    @ApiOperation("Fetch member details")
    public CdFeedDto fetchDetailOfFeeds(@PathVariable String reference) throws Exception {
        CdFeedDto feed = feedService.findByReference(reference);
        return feed;
    }
	
	@PreAuthorize("hasRole('CD_ROLE_REGISTRANT')")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation("Create new feed")
    public boolean addFeeds(@RequestBody CdFeedDto feedDto) throws Exception {
		CdKMemberDto author = memberService.findOne(userUtil.getUserLoginId());
		feedDto.setAuthor(author);
		feedService.save(feedDto);
		response.setStatus(HttpServletResponse.SC_CREATED);
        return true;
    }
	
	@PreAuthorize("hasRole('CD_ROLE_REGISTRANT')")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation("Edit existing feed")
    public boolean editFeed(@RequestBody CdFeedDto feedDto) throws Exception {
		if(feedDto == null || feedDto.getId() == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            throw new CdException(CdErrors.CD_ACCESS_IS_DENIED);
		}
		CdKMemberDto author = memberService.findOne(userUtil.getUserLoginId());
		CdFeedDto existingFeedDto = feedService.findOne(feedDto.getId());
		if(author.getId().intValue() != existingFeedDto.getAuthor().getId().intValue()) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            throw new CdException(CdErrors.CD_ACCESS_IS_DENIED);
		}
		//allow user update title of feed
		if(feedDto.getArticle() != null && feedDto.getArticle().getTitle() != null) {
			existingFeedDto.getArticle().setTitle(feedDto.getArticle().getTitle());
		}
		//allow user update description of feed
		if(feedDto.getArticle() != null && feedDto.getArticle().getDescription() != null) {
			existingFeedDto.getArticle().setDescription(feedDto.getArticle().getDescription());
		}
		//allow user update photos of feed
		if(feedDto.getArticle() != null && feedDto.getArticle().getPhotos() != null) {
			existingFeedDto.getArticle().setPhotos(feedDto.getArticle().getPhotos());
		}
		//allow user update scope of feed
		if(feedDto.getArticle() != null && feedDto.getScope() != null) {
			existingFeedDto.setScope(feedDto.getScope());
		}
		feedService.save(existingFeedDto);
		
        return true;
    }
	
	@PreAuthorize("hasRole('CD_ROLE_REGISTRANT')")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ApiOperation("delete existing feed")
    public boolean deleteFeed(@RequestBody CdFeedDto feedDto) throws Exception {
		if(feedDto == null || feedDto.getId() == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            throw new CdException(CdErrors.CD_ACCESS_IS_DENIED);
		}
		CdKMemberDto author = memberService.findOne(userUtil.getUserLoginId());
		CdFeedDto existingFeedDto = feedService.findOne(feedDto.getId());
		if(author.getId().intValue() != existingFeedDto.getAuthor().getId().intValue()) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            throw new CdException(CdErrors.CD_ACCESS_IS_DENIED);
		}
		feedService.delete(feedDto);
        return true;
    }
	
	@RequestMapping(value = "/{reference}/comment", method = RequestMethod.GET)
    @ApiOperation("Fetch all comments of feeds")
    public Set<CdCommentDto> fetchCommentFeeds(@PathVariable String reference) throws Exception {
        CdFeedDto feed = feedService.findByReference(reference);
        if(feed == null || feed.getId() == null) {
        		throw new CdException(CdErrors.CD_K_RESOURCE_NOT_EXISTS);
        }
        return feed.getArticle().getComments();
    }
	
	
	@PreAuthorize("hasRole('CD_ROLE_REGISTRANT')")
	@RequestMapping(value = "/{reference}/comment", method = RequestMethod.POST)
    @ApiOperation("Post comment for feed")
    public boolean addCommentFeeds(@PathVariable String reference, @RequestBody CdCommentDto cdCommentDto) throws Exception {
        CdFeedDto feed = feedService.findByReference(reference);
        CdKMemberDto member = memberService.findOne(userUtil.getUserLoginId());
        
        if(cdCommentDto.getComment() == null || cdCommentDto.getComment().isEmpty()) {
        		throw new CdException(CdErrors.CD_K_COMMENT_NOT_EXISTS);
        }
        cdCommentDto.setAuthor(member);
        cdCommentDto.setArticle(feed.getArticle());
        commentService.save(cdCommentDto);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return true;
    }

	@RequestMapping(value = "/{reference}/like", method = RequestMethod.GET)
    @ApiOperation("Get likes of feed")
    public Set<CdLikeDto> getLikeFeeds(@PathVariable String reference) throws Exception {
        CdFeedDto feed = feedService.findByReference(reference);
        if(feed == null) {
        		throw new CdException(CdErrors.CD_K_RESOURCE_NOT_EXISTS);
        }
        return feed.getArticle().getLikes();
    }
	
	@PreAuthorize("hasRole('CD_ROLE_REGISTRANT')")
	@RequestMapping(value = "/{reference}/like", method = RequestMethod.POST)
    @ApiOperation("Post like for feed")
    public boolean addLikeFeeds(@PathVariable String reference) throws Exception {
        CdFeedDto feed = feedService.findByReference(reference);
        CdKMemberDto member = memberService.findOne(userUtil.getUserLoginId());
        CdLikeDto likeDto = new CdLikeDto();
        likeDto.setAuthor(member);
        likeDto.setArticle(feed.getArticle());
        likeService.save(likeDto);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return true;
    }
	
	@PreAuthorize("hasRole('CD_ROLE_REGISTRANT')")
	@RequestMapping(value = "/{reference}/like", method = RequestMethod.DELETE)
    @ApiOperation("Un like  feed")
    public boolean deleteLikeFeeds(@PathVariable String reference) throws Exception {
        CdFeedDto feed = feedService.findByReference(reference);
        CdKMemberDto member = memberService.findOne(userUtil.getUserLoginId());
        List<CdLikeDto> likeDtos = likeService.findByAuthorAndArticleId(member, feed.getArticle());
        likeService.delete(likeDtos);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return true;
    }
}
