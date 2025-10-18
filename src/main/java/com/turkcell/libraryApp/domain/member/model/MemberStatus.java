package com.turkcell.libraryApp.domain.member.model;

public enum MemberStatus {
    ACTIVE,     // Kullanıcı aktif, kitap ödünç alabilir
    INACTIVE,   // Hesap dondurulmuş veya pasif
    BANNED      // Yasaklı, kitap alamaz
}