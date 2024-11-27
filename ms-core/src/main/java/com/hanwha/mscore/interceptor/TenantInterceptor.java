package com.hanwha.mscore.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanwha.mscore.context.TenantContext;
import com.hanwha.mscore.context.TenantEnum;
import com.hanwha.mscore.controller.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class TenantInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tenantId = request.getHeader("X-TenantID");

        // tenantId 유효성 검증
        if(!TenantEnum.hasTenantEnum(tenantId)) {
            ObjectMapper mapper = new ObjectMapper();
            ApiResponse<Object> build = ApiResponse.builder()
                .code(HttpServletResponse.SC_BAD_REQUEST)
                .message("Tenant ID is not valid")
                .data(null)
                .build();
            response.getWriter().println(mapper.writeValueAsString(build));
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }

        TenantContext.setCurrentTenant(tenantId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        TenantContext.clear();
    }

}
