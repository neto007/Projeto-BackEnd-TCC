package com.chegaai.utils;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.user.User;
import com.chegaai.user.permissao.Permissao;
import org.springframework.security.access.AccessDeniedException;

public class PermissionUtils {
    public static void verificaPermissao(Permissao permissao, String id) {
        User user = AuthenticationContext.getCurrentUser();

        if(user.hasPermissaoToEstabelecimento(permissao.getValue(), id)) {
            throw new AccessDeniedException("Você não tem permissão para isso.");
        }
    }
}
