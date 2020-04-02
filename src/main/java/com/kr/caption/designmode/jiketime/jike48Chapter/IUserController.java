package com.kr.caption.designmode.jiketime.jike48Chapter;

import com.kr.caption.designmode.jiketime.jike25Chapter.UserVo;

public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
