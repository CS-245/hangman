<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
namespace App;

use Illuminate\Notifications\Notifiable;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Laravel\Passport\HasApiTokens;
use Spatie\Permission\Traits\HasRoles;

/**
 * @author Jeff So
 * @file User.phppackage App
 * @brief User Model
 */
class User extends Authenticatable
{
    use HasRoles;
    use HasApiTokens, notifiable;

    /**
     * DB Table Name.
     *
     * @var string $table
     */
    protected $table = 'kw_user';

    /**
     * DB Table Primary Key.
     *
     * @var string $primaryKey
     */
    protected $primaryKey = 'user_id';

    /**
     * The attributes that are mass assignable.
     *
     * @var array $fillable
     */
    protected $fillable = [
        'first_name','last_name', 'email', 'password'
        , 'company_title' , 'company_name' , 'company_website' , 'certificate_sellers_permit', 'sellers_permit_no'
        , 'certificate_resellers_permit', 'resellers_permit_no', 'cell_phone', 'office_phone1', 'office_phone2'
        , 'fax', 'news_letter_yn', 'where_hear_aboutus', 'del_yn', 'activate_yn',
    ];

    /**
     * The attributes that should be hidden for arrays.
     *
     * @var array $hidden
     */
    protected $hidden = [
        'password', 'remember_token',
    ];

    /**
     * Get User Full Name.
     *
     * @return string
     */
    public function getFullName() {
        return $this->first_name . ' ' . $this->last_name;
    }
}
