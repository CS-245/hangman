<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */

namespace App\Service;

use Illuminate\Http\Request;

/**
 * @author Lenny Yang
 * @file ReportService.php
 * @package App\Service
 * @brief ReportService file
 */
interface ReportService
{
    public function refresh(Request $request);
    
    public function index();
    
    public function import(Request $request);
    
    public function export();
}
