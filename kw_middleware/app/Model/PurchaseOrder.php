<?php

namespace App\Model;

use Illuminate\Database\Eloquent\Model;

class PurchaseOrder extends Model
{
    protected $fillable = [
        
        'purchase_order',
        'department',
        'size',
        'style',
        'color'
        
    ];
}
