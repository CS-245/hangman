@extends('layouts.admin.app')

@section('content')
    {{--<div class="row">--}}
        {{--<div class="col-lg-3">--}}
            {{--<a style="color: #676a6c !important;" href="{{ url('/admin/user/list') }}">--}}
            {{--<div class="ibox float-e-margins">--}}
                {{--<div class="ibox-title">--}}
                    {{--<span class="label label-inverse pull-right">Total</span>--}}
                    {{--<h5>User</h5>--}}
                {{--</div>--}}
                {{--<div class="ibox-content">--}}
                    {{--<h1 class="no-margins " id="widget-user-cnt">0</h1>--}}
                    {{--<div class="stat-percent font-bold text-success"></div>--}}
                    {{--<small>Total User</small>--}}
                {{--</div>--}}
            {{--</div>--}}
            {{--</a>--}}
        {{--</div>--}}

        {{--<div class="col-lg-3">--}}
            {{--<a style="color: #676a6c !important;" href="{{ url('/admin/products/list') }}">--}}
            {{--<div class="ibox float-e-margins">--}}
                {{--<div class="ibox-title">--}}
                    {{--<span class="label label-success pull-right">Total</span>--}}
                    {{--<h5>Product</h5>--}}
                {{--</div>--}}
                {{--<div class="ibox-content">--}}
                    {{--<h1 class="no-margins " id="widget-product-cnt">0</h1>--}}
                    {{--<div class="stat-percent font-bold text-success"></div>--}}
                    {{--<small>Total Product</small>--}}
                {{--</div>--}}
            {{--</div>--}}
            {{--</a>--}}
        {{--</div>--}}
    {{--</div>--}}
@endsection

@section('after-script')
    <script>
        $(document).ready(function () {
            setTimeout(function () {
                toastr.options = {
                    closeButton: true,
                    progressBar: true,
                    showMethod: 'slideDown',
                    positionClass: 'toast-top-center',
                    timeOut: 3000
                };
                toastr.info('', 'Welcome to KW');

            }, 1300);

            $.ajax({
                type: 'GET',
                url: '/report/user/count',
                success: function(data) {
                    $('#widget-user-cnt').removeClass('animated fadeInUp');
                    setTimeout(function() {
                        $('#widget-user-cnt').addClass('animated fadeInUp');
                        $('#widget-user-cnt').text(data);
                    }, 100);
                },
                failure: function(errMsg) {
                    alert(errMsg);
                }
            });

            $.ajax({
                type: 'GET',
                url: '/report/product/count',
                success: function(data) {
                    $('#widget-product-cnt').removeClass('animated fadeInUp');
                    setTimeout(function() {
                        $('#widget-product-cnt').addClass('animated fadeInUp');
                        $('#widget-product-cnt').text(data);
                    }, 100);
                },
                failure: function(errMsg) {
                    alert(errMsg);
                }
            });
        });
    </script>
@endsection
