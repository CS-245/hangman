<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
namespace App\Model;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Support\Facades\DB;

/**
 * @author Jeff So
 * @file KwBaseModel.php
 * @package App\Model
 * @brief KW Common Model.
 */
class KwBaseModel extends Model
{
    /**
     * Native Select Query.
     *
     * @param $query
     * @return \Illuminate\Support\Collection
     */
    public function selectNativeQuery($query) {
        return collect(DB::select($query));
    }
}
