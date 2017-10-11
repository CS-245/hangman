<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
namespace App\Http\Controllers\Restful;

use App\Http\Controllers\Controller;
use App\Model\Item;
use Illuminate\Http\Request;
use Maatwebsite\Excel\Facades\Excel;
use Illuminate\Support\Facades\DB;
use App\Service\ReportServiceImpl as ReportService;


/**
 * @author Lenny Yang
 * @file ItemController.php
 * @package App\Http\Controllers\Restful
 * @brief Restful ItemController \n
 * Show all, import, export items
 */

class ItemController extends Controller
{
    
    protected function index(){
        
        $reportService = new ReportService();
        
        return $reportService->index();
    }
    
    protected function import(Request $request){
        
        $reportService = new ReportService();
        
        return $reportService->import($request);
    }
    
    protected function export(){
        
        $reportService = new ReportService();
        
        return $reportService->export();
    }
}
