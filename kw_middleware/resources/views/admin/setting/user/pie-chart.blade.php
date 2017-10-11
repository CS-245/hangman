<!DOCTYPE html>
@extends('layouts.admin.app')

@section('header')

@endsection
@section('content')
    <input type="hidden" id="hd_define" data-refresh-link="{{ url('/api/v1/reports/refresh') }}">
    <div style="display: none;">
        <input type="hidden" id="act-modal-type">
        <input type="hidden" id="act-modal-user-id">
        <input type="hidden" id="act-modal-user-name">
        <input type="hidden" id="act-modal-user-email">
        <input type="hidden" id="act-modal-table-index">
    	</div>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <button class="btn btn-primary" onclick="javascript:refresh();">Refresh</button>
</head>
<body>

    <!-- Prepare a Dom with size (width and height) for ECharts -->
    <div id="main" style="height:400px"></div>
    <!-- ECharts import -->
    
</body>
    
@endsection

@section('after-script')
    
    <script src="{{ asset('vendor/echart/echarts.min.js') }}"></script>    
    <script src="{{ asset('js/views/admin/setting-pie-list.js') }}"></script>
    
@endsection