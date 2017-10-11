<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */

namespace App\Service;

use App\Model\Item;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Maatwebsite\Excel\Facades\Excel;
use PHPExcel_IOFactory;
use PHPExcel_Shared_Date;

/**
 * @author Lenny Yang
 * @file ReportServiceImpl.php
 * @package App\Service
 * @brief ReportService 구현 부분.
 */
class ReportServiceImpl implements ReportService
{   
    
    /**
     * Restore/Refresh the pie chart
     *
     * @return Array of activated, deleted, non-activated numbers
     */
    
    public function refresh(Request $request){
        $deleted = 0;
        $activated = 0;
        $nonactivated = 0;
        
        $results = DB::select('select * from kw_user');
        
        $varArray = array($activated, $nonactivated, $deleted);
        
        foreach ($results as $result){
            
            if(($result->del_yn) == 'Y'){
                $deleted++;
            }
            
            if(($result->activate_yn)=='Y'){
                $activated++;
            }
            
            else{
                $nonactivated++;
            }
        }
        return array($activated, $nonactivated, $deleted);
     }     
     
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
         if($request->file('imported-file'))
         {
             $path = $request->file('imported-file')->getRealPath();
             $data = Excel::load($path)->toArray();
             
             foreach($data as $list) {
                 foreach ($list as $item) {
                     DB::table('items')->insert([
                         'sender'=> $item['sender'],
                         'receiver' => $item['receiver'],
                         'po_number' => $item['po_number'],
                         'release_number'=> $item['release_number'],
                         'po_date'=> $item['po_date'],
                         'terms_info'=> $item['terms_info'],
                         'fob_info'=> $item['fob_info'],
                         'ship_to_name'=> $item['ship_to_name'],
                         'ship_to_address1'=> $item['ship_to_address1'],
                         'ship_to_address2'=> $item['ship_to_address2'],
                         'ship_to_location'=> $item['ship_to_location'],
                         'ship_to_city'=> $item['ship_to_city'],
                         'ship_to_state'=> $item['ship_to_state'],
                         'ship_to_postal'=> $item['ship_to_postal'],
                         'ship_to_country'=> $item['ship_to_country'],
                         'ship_to_contact'=> $item['ship_to_contact'],
                         'bill_to_name'=> $item['bill_to_name'],
                         'bill_to_address1'=> $item['bill_to_address1'],
                         'bill_to_address2'=> $item['bill_to_address2'],
                         'bill_to_location'=> $item['bill_to_location'],
                         'bill_to_city'=> $item['bill_to_city'],
                         'bill_to_state'=> $item['bill_to_state'],
                         'bill_to_postal'=> $item['bill_to_postal'],
                         'bill_to_country'=> $item['bill_to_country'],
                         'bill_to_contact'=> $item['bill_to_contact'],
                         'hdr_user_defined_field1'=> $item['hdr_user_defined_field1'],
                         'hdr_user_defined_field2'=> $item['hdr_user_defined_field2'],
                         'hdr_user_defined_field3'=> $item['hdr_user_defined_field3'],
                         'hdr_user_defined_field4'=> $item['hdr_user_defined_field4'],
                         'hdr_user_defined_field5'=> $item['hdr_user_defined_field5'],
                         'hdr_user_defined_field6'=> $item['hdr_user_defined_field6'],
                         'hdr_user_defined_field7'=> $item['hdr_user_defined_field7'],
                         'hdr_user_defined_field8'=> $item['hdr_user_defined_field8'],
                         'hdr_user_defined_field9'=> $item['hdr_user_defined_field9'],
                         'hdr_user_defined_field10'=> $item['hdr_user_defined_field10'],
                         'hdr_user_defined_field11'=> $item['hdr_user_defined_field11'],
                         'hdr_user_defined_field12'=> $item['hdr_user_defined_field12'],
                         'hdr_user_defined_field13'=> $item['hdr_user_defined_field13'],
                         'hdr_user_defined_field14'=> $item['hdr_user_defined_field14'],
                         'hdr_user_defined_field15'=> $item['hdr_user_defined_field15'],
                         'hdr_user_defined_field16'=> $item['hdr_user_defined_field16'],
                         'hdr_user_defined_field17'=> $item['hdr_user_defined_field17'],
                         'hdr_user_defined_field18'=> $item['hdr_user_defined_field18'],
                         'hdr_user_defined_field19'=> $item['hdr_user_defined_field19'],
                         'hdr_user_defined_field20'=> $item['hdr_user_defined_field20'],
                         'notes'=> $item['notes'],
                         'line_nbr'=> $item['line_nbr'],
                         'supplier_item_nbr'=> $item['supplier_item_nbr'],
                         'item_description'=> $item['item_description'],
                         'quantity'=> $item['quantity'],
                         'unit_price'=> $item['unit_price'],
                         'uom_basis_of_uom'=> $item['uom_basis_of_uom'],
                         'buyer_item_nbr'=> $item['buyer_item_nbr'],
                         'manufacturer_item_nbr'=> $item['manufacturer_item_nbr'],
                         'dtl_user_defined_field1'=> $item['dtl_user_defined_field1'],
                         'dtl_user_defined_field2'=> $item['dtl_user_defined_field2'],
                         'dtl_user_defined_field3'=> $item['dtl_user_defined_field3'],
                         'dtl_user_defined_field4'=> $item['dtl_user_defined_field4'],
                         'dtl_user_defined_field5'=> $item['dtl_user_defined_field5'],
                         'dtl_user_defined_field6'=> $item['dtl_user_defined_field6'],
                         'dtl_user_defined_field7'=> $item['dtl_user_defined_field7'],
                         'dtl_user_defined_field8'=> $item['dtl_user_defined_field8'],
                         'dtl_user_defined_field9'=> $item['dtl_user_defined_field9'],
                         'dtl_user_defined_field10'=> $item['dtl_user_defined_field10'],
                         'dtl_user_defined_field11'=> $item['dtl_user_defined_field11'],
                         'dtl_user_defined_field12'=> $item['dtl_user_defined_field12'],
                         'dtl_user_defined_field13'=> $item['dtl_user_defined_field13'],
                         'dtl_user_defined_field14'=> $item['dtl_user_defined_field14'],
                         'dtl_user_defined_field15'=> $item['dtl_user_defined_field15'],
                         'dtl_user_defined_field16'=> $item['dtl_user_defined_field16'],
                         'dtl_user_defined_field17'=> $item['dtl_user_defined_field17'],
                         'dtl_user_defined_field18'=> $item['dtl_user_defined_field18'],
                         'dtl_user_defined_field19'=> $item['dtl_user_defined_field19'],
                         'dtl_user_defined_field20'=> $item['dtl_user_defined_field20'],
                         'po_purpose'=> $item['po_purpose'],
                         'sac_info'=> $item['sac_info'],
                         'delivery_date_requested'=> $item['delivery_date_requested'],
                         'last_delivery_date_requested'=> $item['last_delivery_date_requested'],
                         'sub_line_item'=> $item['sub_line_item'],
                         'item_info'=> $item['item_info']
                     ]);
                 }
             }
         }
         return back();
         
//          if($request->file('imported-file'))
//          {
//              $path = $request->file('imported-file')->getRealPath();
//              $data = Excel::load($path)->toArray();
             
//              Excel::filter('chunk')->load($path)->chunk(1, function($results) {
//                      DB::table('items')->insert($list->toArray());
//              });
             
//              $inputFileType = PHPExcel_IOFactory::identify($path);
//              $objReader = PHPExcel_IOFactory::createReader($inputFileType);
//              $objReader->setReadDataOnly(false);
//              $objReader = $objReader->load($path);
//              $sheet_count = $objReader->getSheetCount();
//              for($sheet_num = 0; $sheet_num < $sheet_count; ++$sheet_num){
//                 $objReader->setActiveSheetIndex($sheet_num);
//                 $sheet = $objReader->getActiveSheet();
                
//                 $row_width = -1;
//                 $colNames = [];
//                 //Reads each row of the sheet
//                 foreach ($sheet->getRowIterator() as $row)
//                 {
//                     $dbRows=[];
//                     $row_num=0;
//                     $cellIterator = $row->getCellIterator();
//                     $cellIterator->setIterateOnlyExistingCells(false);
                    
//                     $col_num = 0;

//                     $col_values = [];
                    
//                     $row_empty = true;
//                     //Reads each cell of the row
//                     foreach($cellIterator as $cell)
//                     {
//                         if($row_width != -1 && $col_num >= $row_width) {
//                             break;
//                         }
//                         //If creating a new table, grab first row as column titles
//                         if($row_num == 0)
//                         {
//                             if($cell->getValue() === NULL || $cell->getValue() === '')
//                             {
//                                 $row_width = $col_num;
//                                 break;
//                             }
//                             $row_empty = false;
//                             $colNames[] = $cell->getValue();
//                             $set_cols = true;
//                             //Eliminate duplicate entry of column names
//                             $completed_columns[] = $cell->getValue();
//                         }
//                         else {
//                             //Operation per cell
//                             if(PHPExcel_Shared_Date::isDateTime($cell))
//                             {
//                                 $row_empty = false;
//                                 $col_values[$colNames[$col_num]] = date($this->dateFormat, PHPExcel_Shared_Date::ExcelToPHP($cell->getValue()));
//                             }
//                             else if(!($cell->getValue() === NULL || $cell->getValue() === '') || !$row_empty)
//                             {
//                                 $row_empty = false;
//                                 $col_values[$colNames[$col_num]] = $this->translateExcelCode($this->literalChars($cell->getValue()));
//                             }
//                             $completed_columns[] = $this->table_column_names($sheet_num)[$col_num];
//                         }
//                         $col_num += 1;
//                     }
//                     //If empty row encountered, Break Loop
//                     if($row_empty)
//                     {
//                         break;
//                     }
                    
//                     $tempDAO = $col_values;
//                     if($row_num % 1024 != 1)
//                     {
//                         $dbRows[] = $tempDAO;
//                     }
//                     else
//                     {
//                         if(count($dbRows))
//                         {
//                             DB::table('items')->insert($dbRows);
//                         }
//                         $dbRows = array($tempDAO);
//                     }
//                     $row_num += 1;
//                 }
//                 if(count($dbRows))
//                 {
//                     DB::table('items')->insert($dbRows);
//                 }
//              }
//              foreach($results as $list) {
//                  Item::insert($list);
//              }         
    //          }
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
     }
}
