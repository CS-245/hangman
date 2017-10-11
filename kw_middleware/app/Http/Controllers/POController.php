<?php

namespace App\Http\Controllers;

use App\Model\Item;
use App\Model\PurchaseOrder;
use Illuminate\Http\Request;

class POController extends Controller
{
    public function index()
    {
        $po   = PurchaseOrder::all();
        return view('/po', compact('po','pos'));
    }
}
