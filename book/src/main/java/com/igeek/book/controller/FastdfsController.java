package com.igeek.book.controller;

import com.igeek.common.util.R;
import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/29 14:33
 */
@RestController
@RequestMapping("/fastdfs")
@Api(tags = {"file"})
public class FastdfsController {

    @Autowired
    private FastFileStorageClient storageClient;

    /**
     * 上传文件
     *
     * @param file 文件
     * @return
     */
    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public R uploadFile(MultipartFile file) {
        try {
            StorePath storePath = storageClient.uploadFile(file.getBytes(), FilenameUtils.getExtension(file.getOriginalFilename()));
            return R.success(storePath.getFullPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok();
    }

//
//    /**
//     * 预览文件
//     *
//     * @param path     文件路径
//     * @param response
//     */
//    @ApiOperation("下载文件")
//    @GetMapping("/file")
//    public void getFile(String path, HttpServletResponse response) {
//        StorePath storePath = StorePath.praseFromUrl(path);
//        ServletOutputStream outputStream = null;
//        try {
//            outputStream = response.getOutputStream();
//            outputStream.write(storageClient.downloadFile(storePath.getGroup(), storePath.getPath(), InputStream::readAllBytes));
//            outputStream.flush();
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}