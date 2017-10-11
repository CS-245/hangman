<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
namespace App\Http\Controllers;

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
    
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        
        $items   = Item::all();
        return view('/items', compact('items','item'));
    }
    
    /**
     * import a file in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function import(Request $request)
    {
        $reportService = new ReportService();
        
        return $reportService->import($request);
    }
    
    /**
     * export a file in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function export(){
        $items = Item::all();
        Excel::create('items', function($excel) use($items) {
            $excel->sheet('ExportFile', function($sheet) use($items) {
                $sheet->fromArray($items);
            });
        })->export('csv');
        
    }
    public function console($data) {
        $output = print_r($data);
        echo "<pre><script>console.log( 'Debug Objects: " . $output . "' );</script></pre>";
    }}
