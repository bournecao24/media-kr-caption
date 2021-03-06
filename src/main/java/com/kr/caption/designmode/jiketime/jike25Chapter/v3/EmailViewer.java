package com.kr.caption.designmode.jiketime.jike25Chapter.v3;

import com.kr.caption.designmode.jiketime.jike25Chapter.v2.EmailSender;
import com.kr.caption.designmode.jiketime.jike25Chapter.v2.RequestStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmailViewer implements StatViewer {

    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();


    public EmailViewer() {
        this.emailSender = new EmailSender(/*省略参数*/);
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long durationInMillis) {
// format the requestStats to HTML style.
// send it to email toAddresses.
    }
}
