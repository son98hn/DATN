package com.example.datn.Utils;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
    public static void showMessage(HttpServletRequest request) {
        if (request.getParameter("message") != null) {
            String messageResponse = "";
            String alert = "";
            String message = request.getParameter("message");
            switch (message) {
                case "insert_success":
                    messageResponse = "Insert success";
                    alert = "success";
                    break;
                case "update_success":
                    messageResponse = "Update success";
                    alert = "success";
                    break;
                case "delete_success":
                    messageResponse = "Delete success";
                    alert = "success";
                    break;
                case "error_system":
                    messageResponse = "Error system";
                    alert = "danger";
                    break;
            }
            request.setAttribute("messageResponse", messageResponse);
            request.setAttribute("alert", alert);
        }
    }
}
