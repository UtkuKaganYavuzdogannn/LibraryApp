package com.turkcell.libraryApp.application.member.dto;

public enum MemberStatusDto {
    ACTIVE,     // Kullanıcı aktif, kitap ödünç alabilir
    INACTIVE,   // Hesap dondurulmuş veya pasif
    BANNED      // Yasaklı, kitap alamaz
}
